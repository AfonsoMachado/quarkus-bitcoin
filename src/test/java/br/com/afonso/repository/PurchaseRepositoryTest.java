package br.com.afonso.repository;

import br.com.afonso.purchase.model.Purchase;
import br.com.afonso.purchase.repository.PurchaseRepository;
import io.quarkus.test.InjectMock;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

@QuarkusTest
public class PurchaseRepositoryTest {

    @InjectMock
    PurchaseRepository purchaseRepository;

    @Test
    public void testIfListAllReturnsAllPurchases() {
        Purchase firstPurchase = new Purchase();
        Purchase secondPurchase = new Purchase();

        List<Purchase> purchases = new ArrayList<Purchase>();
        purchases.add(firstPurchase);
        purchases.add((secondPurchase));

        Mockito.when(purchaseRepository.listAll())
                .thenReturn(purchases);

        Assertions.assertSame(secondPurchase, purchaseRepository.listAll().get(1));
    }
}
