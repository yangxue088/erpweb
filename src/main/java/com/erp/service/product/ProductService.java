package com.erp.service.product;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import com.erp.dao.product.ProductDao;
import com.erp.service.publish.Product;

@Service
public class ProductService {

	@Autowired
	private ProductDao productDao;

	public void createPicture(String filename, InputStream is, int productId) {
		productDao.savePicture(filename, is, productId);
	}

	public int createProduct(Product product) {
		int productId = productDao.createProduct(product);
		productDao.createStocks(productId, product.getStocks());
		return productId;
	}

	public void updateProduct(int id, Product product) {
		productDao.updateProduct(id, product);

		productDao.updateStocks(id, product.getStocks());
	}

	public Product getProduct(int productId) {
		return productDao.getProduct(productId);
	}

	public List<String> getPictures(int productId, String topath) {
		return productDao.getPictures(productId, topath);
	}

	public List<String[]> getStocks(int productId) {
		return productDao.getStocks(productId);
	}

	public void deletePicture(int id) {
		productDao.deletePicture(id);
	}

	public JsonTable getProductTable(String title, String code, String group, String inventory, int offset, int limit) {
		JsonTable table = new JsonTable();

		table.setTotal(200);

		for (int i = offset; i < offset + limit; ++i) {
			final int j = i;
			table.getRows().add(new HashMap<String, String>() {
				private static final long serialVersionUID = 1L;

				{
					put("id", String.valueOf(19));
					put("title", "newtitle" + j);
					put("group", "newgroup" + j);
					put("inventory", "333" + j);
				}
			});
		}

		return table;
	}
}
