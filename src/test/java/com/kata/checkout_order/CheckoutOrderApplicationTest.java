package com.kata.checkout_order;

import com.kata.checkout_order.controllers.DiscountController;
import com.kata.checkout_order.controllers.GroceryItemController;
import com.kata.checkout_order.controllers.QueryController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

/**
 I name unit test methods like [UnitOfWork_StateUnderTest_ExpectedBehavior]
 @see <a href="https://osherove.com/blog/2005/4/3/naming-standards-for-unit-tests.html">Reference</a>
*/
@SpringBootTest
class CheckoutOrderApplicationTest {

	@Autowired
	private QueryController queryController;
	@Autowired
	private GroceryItemController groceryItemController;
	@Autowired
	private DiscountController discountController;

	@Test
	public void contextLoads() {
		assertThat(queryController).isNotNull();
		assertThat(groceryItemController).isNotNull();
		assertThat(discountController).isNotNull();
	}}
