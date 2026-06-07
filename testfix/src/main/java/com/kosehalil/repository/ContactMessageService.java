package com.kosehalil.repository;

import java.util.List;
import org.springframework.stereotype.Service;
import com.kosehalil.model.ContactMessage;

@Service
public class ContactMessageService {

    private final ContactMessageRepository repository;

    public ContactMessageService(ContactMessageRepository repository) {
        this.repository = repository;
    }

    public void save(ContactMessage message) {
        repository.save(message);
    }

    public List<ContactMessage> getAll() {
        return repository.findAll();
    }
}
