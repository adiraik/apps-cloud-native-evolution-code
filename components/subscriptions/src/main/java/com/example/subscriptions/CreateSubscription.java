package com.example.subscriptions;

// import com.example.billing.ChargeUser;
import com.example.billing.Client;

import com.example.email.SendEmail;

public class CreateSubscription {

   // private final ChargeUser chargeUser;
   private Client billingClient;

    private final SendEmail emailSender;
    private final SubscriptionRepository subscriptions;

    public CreateSubscription(
        //    ChargeUser chargeUser,
        Client billingClient,

            SendEmail emailSender, SubscriptionRepository subscriptions) {
       // this.chargeUser = chargeUser;
        this.billingClient = billingClient;
        this.emailSender = emailSender;
        this.subscriptions = subscriptions;
    }

    public void run(String userId, String packageId) {
        subscriptions.create(new Subscription(userId, packageId));
     //   chargeUser.run(userId, 100);
        billingClient.billUser("abc123", 100);
        emailSender.run("me@example.com", "Subscription Created", "Some email body");
    }
}
