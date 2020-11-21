package ua.uz.alex.contloller;

import com.google.gson.Gson;
import ua.uz.alex.domain.Bucket;
import ua.uz.alex.domain.Product;
import ua.uz.alex.dto.BucketDto;
import ua.uz.alex.service.BucketService;
import ua.uz.alex.service.ProductService;
import ua.uz.alex.service.impl.BucketServiceImpl;
import ua.uz.alex.service.impl.ProductServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@WebServlet("/bucket")
public class BucketController extends HttpServlet {

    private BucketService bucketService = BucketServiceImpl.getBucketService();
    private ProductService productService = ProductServiceImpl.getProductService();


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Bucket> buckets = bucketService.readAll();
        Map<Integer, Product> idToProduct = productService.readAllMap();
        List<BucketDto> listOfBucketDtos = map(buckets, idToProduct);

        String json = new Gson().toJson(listOfBucketDtos);
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(json);
    }


    public List<BucketDto> map(List<Bucket> buckets, Map<Integer, Product> idToProduct){

        return	buckets.stream().map(bucket->{
            BucketDto bucketDto = new BucketDto();
            bucketDto.bucketId = bucket.getId();
            bucketDto.purchaseDate = bucket.getPurchaseDate();

            Product product = idToProduct.get(bucket.getProductId());
            bucketDto.name = product.getName();
            bucketDto.description = product.getDescription();
            bucketDto.price = product.getPrice();

            return bucketDto;
        }).collect(Collectors.toList());

    }

}
