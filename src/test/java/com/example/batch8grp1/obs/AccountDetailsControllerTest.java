package com.example.batch8grp1.obs;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import com.batch8grp1.obs.controller.AccountDetailsController;
import com.batch8grp1.obs.payload.response.AccountDetailsResponse;
import com.batch8grp1.obs.service.AccountDetailsService;

public class AccountDetailsControllerTest {

    @Mock
    private AccountDetailsService accountDetailsService;

    @InjectMocks
    private AccountDetailsController accountDetailsController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetAccountDetails_Success() {
        String netbankingId = "netbanking123";

        AccountDetailsResponse expectedResponse = new AccountDetailsResponse("account123", "Mr.", "John", "Doe", "2023-08-25", 1000);

        when(accountDetailsService.getAccountDetails(netbankingId)).thenReturn(expectedResponse);

        ResponseEntity<?> responseEntity = accountDetailsController.getAccountDetails(netbankingId);

        assertNotNull(responseEntity);
        assertEquals(200, responseEntity.getStatusCodeValue());

        AccountDetailsResponse response = (AccountDetailsResponse) responseEntity.getBody();
        assertNotNull(response);
        assertEquals(expectedResponse.getAccountId(), response.getAccountId());
        assertEquals(expectedResponse.getFullName(), response.getFullName());
        assertEquals(expectedResponse.getCreatedAt(), response.getCreatedAt());
        assertEquals(expectedResponse.getBalance(), response.getBalance());
    }

    // Add more test cases for other scenarios

}
