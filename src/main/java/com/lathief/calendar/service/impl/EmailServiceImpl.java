package com.lathief.calendar.service.impl;

import com.lathief.calendar.service.EmailService;
import com.lathief.calendar.utils.EngagementEmailStuff;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring6.SpringTemplateEngine;

import java.util.Locale;

@Service
public class EmailServiceImpl implements EmailService {
    @Autowired
    JavaMailSender emailSender;
    @Autowired
    SpringTemplateEngine templateEngine;
    public void sendEngagement(EngagementEmailStuff stuff) {
        final MimeMessagePreparator preparator = (MimeMessage message) -> {
            final MimeMessageHelper helper = new MimeMessageHelper(message);
            helper.setTo(stuff.getRecipient());
            helper.setSubject(stuff.getTitle());
            helper.setText(
                    templateEngine.process("engagement-email", new Context(Locale.ENGLISH, stuff.getProps())), true
            );
        };
        emailSender.send(preparator);
    }
}
