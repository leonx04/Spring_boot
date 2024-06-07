package com.example.buoi_1.controllers;

import com.example.buoi_1.entity.NhanVienEntity;
import com.example.buoi_1.entity.UserSession;
import com.example.buoi_1.repository.asm2.NhanVienRepo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class LoginControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private NhanVienRepo nvRepo;

    @Test
    public void testConcurrentLoginWithRepoData() throws Exception {
        int numOfUsers = 1000;
        ExecutorService executorService = Executors.newFixedThreadPool(100); // Sử dụng 100 threads

        List<NhanVienEntity> testUsers = nvRepo.findTop1000ByOrderByIdAsc(); // Lấy 1000 tài khoản

        MockHttpSession[] sessions = new MockHttpSession[numOfUsers];

        long startTime = System.nanoTime(); // Bắt đầu đo thời gian

        for (int i = 0; i < numOfUsers; i++) {
            final int index = i;
            executorService.submit(() -> {
                try {
                    MvcResult result = mockMvc.perform(post("/login")
                                    .param("tenDN", testUsers.get(index).getTenDN())
                                    .param("matKhau", testUsers.get(index).getMatKhau()))
                            .andExpect(status().isFound())
                            .andExpect(redirectedUrl("/home"))
                            .andReturn();

                    MockHttpSession session = (MockHttpSession) result.getRequest().getSession();
                    sessions[index] = session;
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
        }

        executorService.shutdown();
        executorService.awaitTermination(60, TimeUnit.SECONDS); // Tăng thời gian chờ lên 60 giây

        long endTime = System.nanoTime(); // Kết thúc đo thời gian
        long totalTime = endTime - startTime; // Tính tổng thời gian

        System.out.println("Danh sách tên đăng nhập, mật khẩu và session:");
        for (int i = 0; i < numOfUsers; i++) {
            NhanVienEntity user = testUsers.get(i);
            MockHttpSession session = sessions[i];
            UserSession userSession = (UserSession) session.getAttribute("userSession");

            System.out.println("Tên đăng nhập: " + user.getTenDN());
            System.out.println("Mật khẩu: " + user.getMatKhau());
            System.out.println("Session ID: " + session.getId());
            System.out.println("Logged In: " + userSession.isLoggedIn());
            System.out.println("---");
        }

        System.out.println("Tổng số bản ghi test: " + numOfUsers);
        System.out.println("Tổng thời gian test (milliseconds): " + totalTime / 1_000_000);
    }
}
