package pkg;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.when;

public class LoanServiceTest {

    @InjectMocks
    private LoanService loanService;

    @Mock
    private UserService userService;

    @Mock
    private CreditScoreServiceExperian experian;

    @Mock
    private CreditScoreServiceEquifax equifax;

    @Mock
    private MissedPaymentService paymentService;


    @Before
    public void setUp() {
        loanService = new LoanService();
        MockitoAnnotations.initMocks(this);
    }


    @Test
    public void loanFor850Fico() throws Exception {
        when(userService
                .getSSN(anyString()))
                .thenReturn("123456789");

        when(equifax.getFico(anyString()))
                .thenReturn(850);

        when(experian.getFico(anyString()))
                .thenReturn(850);

        when(paymentService.missedPayment(6))
                .thenReturn(3);

        when(paymentService.missedPayment(24))
                .thenReturn(10);


        int interestRate = loanService.getInterestRate("user2", 24);

        System.out.println(interestRate);
    }



}
