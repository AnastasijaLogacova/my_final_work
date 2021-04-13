package lu.lv.gradledemo.finalWork.service;

import tryouts.tryouts.lesson11.finalWork.model.Product;
import tryouts.tryouts.lesson11.finalWork.model.ProductCategory;
import tryouts.tryouts.lesson11.finalWork.model.ProductData;
import tryouts.tryouts.lesson11.finalWork.model.ProductInputData;
import tryouts.tryouts.lesson11.finalWork.repository.ProductRepository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ProductService {

    private ProductRepository repository = new ProductRepository(new HashMap<>());

    public void save(ProductInputData productInputData) {
        Product product = convertFrom(productInputData);
        repository.save(product);
    }

    public List<ProductData> findAll() {
        List<ProductData> result = new ArrayList<>();
        for (Product product : repository.findAll()) {
            result.add(covertFrom(product));
        }
        return result;
    }

    private ProductData covertFrom(Product product) {
        return new ProductData(
                product.getId().toString(),
                product.getName(),
                product.getPrice().toPlainString());
    }

    private Product convertFrom(ProductInputData productInputData) {
        Product product = new Product();
        product.setName(productInputData.getName());
        product.setPrice(BigDecimal.valueOf(productInputData.getPrice()));
        product.setCategory(ProductCategory.valueOf(productInputData.getCategory()));
        product.setDiscount(BigDecimal.valueOf(productInputData.getDiscount()));
        product.setDescription(productInputData.getDescription());
        return product;
    }
}

