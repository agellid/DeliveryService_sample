package deliveryservicesample.infra;
import deliveryservicesample.domain.*;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;


@RestController
// @RequestMapping(value="/stores")
@Transactional
public class StoreController {
    @Autowired
    StoreRepository storeRepository;



    @RequestMapping(value = "stores/{id}/orderreject",
        method = RequestMethod.PUT,
        produces = "application/json;charset=UTF-8")
    public Store orderReject(@PathVariable(value = "id") Long id, HttpServletRequest request, HttpServletResponse response) throws Exception {
            System.out.println("##### /store/orderReject  called #####");
            Optional<Store> optionalStore = storeRepository.findById(id);
            
            optionalStore.orElseThrow(()-> new Exception("No Entity Found"));
            Store store = optionalStore.get();
            store.orderReject();
            
            storeRepository.save(store);
            return store;
            
    }
    



    @RequestMapping(value = "stores/{id}/cookbegin",
        method = RequestMethod.PUT,
        produces = "application/json;charset=UTF-8")
    public Store cookBegin(@PathVariable(value = "id") Long id, HttpServletRequest request, HttpServletResponse response) throws Exception {
            System.out.println("##### /store/cookBegin  called #####");
            Optional<Store> optionalStore = storeRepository.findById(id);
            
            optionalStore.orElseThrow(()-> new Exception("No Entity Found"));
            Store store = optionalStore.get();
            store.cookBegin();
            
            storeRepository.save(store);
            return store;
            
    }
    



    @RequestMapping(value = "stores/{id}/cookend",
        method = RequestMethod.PUT,
        produces = "application/json;charset=UTF-8")
    public Store cookEnd(@PathVariable(value = "id") Long id, HttpServletRequest request, HttpServletResponse response) throws Exception {
            System.out.println("##### /store/cookEnd  called #####");
            Optional<Store> optionalStore = storeRepository.findById(id);
            
            optionalStore.orElseThrow(()-> new Exception("No Entity Found"));
            Store store = optionalStore.get();
            store.cookEnd();
            
            storeRepository.save(store);
            return store;
            
    }
    



    @RequestMapping(value = "stores/{id}/deliveryrequest",
        method = RequestMethod.PUT,
        produces = "application/json;charset=UTF-8")
    public Store deliveryRequest(@PathVariable(value = "id") Long id, HttpServletRequest request, HttpServletResponse response) throws Exception {
            System.out.println("##### /store/deliveryRequest  called #####");
            Optional<Store> optionalStore = storeRepository.findById(id);
            
            optionalStore.orElseThrow(()-> new Exception("No Entity Found"));
            Store store = optionalStore.get();
            store.deliveryRequest();
            
            storeRepository.save(store);
            return store;
            
    }
    



    @RequestMapping(value = "stores/{id}/orderaccept",
        method = RequestMethod.PUT,
        produces = "application/json;charset=UTF-8")
    public Store orderAccept(@PathVariable(value = "id") Long id, HttpServletRequest request, HttpServletResponse response) throws Exception {
            System.out.println("##### /store/orderAccept  called #####");
            Optional<Store> optionalStore = storeRepository.findById(id);
            
            optionalStore.orElseThrow(()-> new Exception("No Entity Found"));
            Store store = optionalStore.get();
            store.orderAccept();
            
            storeRepository.save(store);
            return store;
            
    }
    



}
