package com.pioneers.rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@SpringBootApplication
public class RestApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestApplication.class, args);

	}
}
//
//    @Mock
//    private LoyaltyAccountRepository accountRepository;
//
//    @Mock
//    private LoyaltyTransactionRepository transactionRepository;
//
//    @Mock
//    private PointsLotRepository pointsLotRepository;
//
//    @InjectMocks
//    private LoyaltyAccountService loyaltyAccountService;
//
//    @Test
//    void getAccount_shouldReturnAccountResponse() {
//
//        // Arrange
//        Long accountId = 1L;
//
//        Customer customer = Customer.builder().id(10L).build();
//
//        LoyaltyProgram program = LoyaltyProgram.builder().id(20L).build();
//
//        LoyaltyAccount account = LoyaltyAccount.builder().id(accountId).customer(customer).program(program)
//                .availablePoints(100).lockedPoints(20).reservedPoints(10).status(AccountStatus.ACTIVE).build();
//
//        when(accountRepository.findById(accountId)).thenReturn(Optional.of(account));
//
//        when(pointsLotRepository
//                .findFirstByAccount_IdAndStatusAndRemainingPointsGreaterThanOrderByExpiresAtAscUnlockAtAsc(
//                        anyLong(), any(), anyInt())).thenReturn(Optional.empty());
//
//        // Act
//
//        var response = loyaltyAccountService.findAccount(accountId);
//
//        // Assert
//
//        assertNotNull(response);
//        assertEquals("1", response.getAccountId());
//        assertEquals("10", response.getCustomerId());
//        assertEquals("20", response.getProgramId());
//        assertEquals("ACTIVE", response.getAccountStatus());
//
//        assertNotNull(response.getBalance());
//
//        assertEquals(100L, response.getBalance().getAvailable());
//        assertEquals(20L, response.getBalance().getLocked());
//        assertEquals(10L, response.getBalance().getReserved());
//        assertEquals(130L, response.getBalance().getTotalOwned());
//
//        verify(accountRepository).findById(accountId);
//    }
//