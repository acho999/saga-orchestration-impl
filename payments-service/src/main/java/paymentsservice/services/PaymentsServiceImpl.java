package paymentsservice.services;

import DTO.UserDTO;
import paymentsservice.repos.PaymentsRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

@Service
public class PaymentsServiceImpl implements PaymentsService {

    @Autowired
    private PaymentsRepo repo;

    @Autowired
    private ModelMapper mapper;

    @Override
    @Transactional
    public Collection<UserDTO> getAll() {

        return null;
    }
}
