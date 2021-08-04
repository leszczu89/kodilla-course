package com.kodilla.hibernate.invoice.dao;

import com.kodilla.hibernate.invoice.Invoice;
import com.kodilla.hibernate.invoice.Item;
import com.kodilla.hibernate.invoice.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

@SpringBootTest
public class InvoiceDaoTestSuite {

    @Autowired
    private InvoiceDao invoiceDao;

    @Test
    void testInvoiceDaoSave() {
        //Given
        Product product1 = new Product("Telephone");
        Product product2 = new Product("TV");
        Product product3 = new Product("Radio");

        Item item1 = new Item(new BigDecimal(1500), 2, product1);
        Item item2 = new Item(new BigDecimal(2000), 1, product2);
        Item item3 = new Item(new BigDecimal(200), 4, product3);
        Item item4 = new Item(new BigDecimal(600), 5, product1);

        Invoice invoice = new Invoice("2021/08/01");
        invoice.getItems().add(item1);
        invoice.getItems().add(item2);
        invoice.getItems().add(item3);
        invoice.getItems().add(item4);

        //When
        invoiceDao.save(invoice);
        int id = invoice.getId();

        //Then
        assertNotEquals(0, id);

        //CleanUp
        try {
            invoiceDao.delete(invoice);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

    }
}
