package paymentsservice.endpoints;

import com.angel.models.DTO.PaymentRequestDTO;
import com.angel.models.DTO.PaymentResponseDTO;
import com.angel.models.DTO.UserDTO;
import io.swagger.annotations.ApiOperation;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.modelmapper.spi.MatchingStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import paymentsservice.models.Payment;
import paymentsservice.services.api.PaymentsService;
import paymentsservice.services.api.UsersService;

@RestController
@RequestMapping(value = "/users")
public class UsersController {

    private UsersService service;
    private PaymentsService paymentsService;
    private ModelMapper mapper;

    @Autowired
    public UsersController(UsersService service,
                           PaymentsService paymentsService, ModelMapper mapper) {
        this.service = service;
        this.paymentsService = paymentsService;
        this.mapper = mapper;
    }

    @ApiOperation("Creates a user")
    @RequestMapping(value = "/create",
        method = RequestMethod.POST,
        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<UserDTO> createUser(@RequestBody UserDTO user){

        UserDTO dto = this.service.createUser(user);
        return new ResponseEntity<>(dto, null, HttpStatus.CREATED);
    }

    @ApiOperation("Gets a user by id.")
    @RequestMapping(value = "/get/{id}",
        method = RequestMethod.POST,
        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<UserDTO> getUser(@PathVariable String id){

        UserDTO dto = this.service.getUser(id);
        return new ResponseEntity<>(dto, null, HttpStatus.CREATED);
    }

    @ApiOperation("Gets a payment by id")
    @RequestMapping(value = "/get/payment/{id}",
        method = RequestMethod.GET,
        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<PaymentResponseDTO> getPayment(@PathVariable String id){
        this.mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        PaymentResponseDTO dto = this.mapper.map(this.paymentsService.getPayment(id), PaymentResponseDTO.class);
        return new ResponseEntity<>(dto, null, HttpStatus.OK);
    }


}
