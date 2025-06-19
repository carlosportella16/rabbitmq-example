
# 📡 RabbitMQ Integration Example using Microservices in Java Spring Boot

This project demonstrates a practical implementation of an **asynchronous messaging system** with **RabbitMQ**, using **Java**, **Spring Boot**, and **microservices**. The architecture covers concepts like **Exchanges**, **Routing Keys**, **Wildcards**, and **audit logging**.

## 🛠️ Solution Architecture

The solution consists of **4 main microservices**, communicating via RabbitMQ:

| Microservice | Responsibility |
|--------------|----------------|
| **pixms** | Acts as the producer (Publisher) of PIX messages and also as the service representing the Exchange. Sends messages with different Routing Keys. |
| **pfms** | Consumer responsible for processing PIX messages for Individuals (PF - Pessoa Física). |
| **pjms** | Consumer responsible for processing PIX messages for Businesses (PJ - Pessoa Jurídica). |
| **auditms** | Service that consumes all messages (Wildcard Binding) for auditing purposes, tracking all events in the exchange. |

## 📌 Demonstrated Concepts

✅ Use of **Exchanges**  
✅ Definition of **Queues** for each consumer (PF, PJ, Audit)  
✅ Use of **Routing Keys** for message segmentation  
✅ Configuration of **Wildcard Bindings** in the audit service

## 🖥️ Solution Diagram

Below is a visual overview of the architecture with the message flows:

![RabbitMQ Microservices Architecture](./bc7a517d-f8ed-46ac-aaa9-f7cc78fcf51c.png)

## 🚀 Technologies Used

- Java 21+
- Spring Boot
- Spring AMQP
- RabbitMQ
- Docker (for messaging infrastructure)
- Maven

## 📂 Project Structure

```bash
rabbitmq-microservices-example/
├── pixms/       # Producer + Exchange
├── pfms/        # Consumer - Individuals (PF)
├── pjms/        # Consumer - Businesses (PJ)
├── auditms/     # Consumer - Audit (Wildcard Binding)
└── README.md
```

## ▶️ How to Run Locally

1. **Start RabbitMQ with Docker:**

```bash
docker compose up
```

2. **Build all microservices:**

3. **Run each microservice:**


## 📤 Testing PIX Message Sending

- **RabbitMQ Management Console:**  
  Access: [http://localhost:15672/](http://localhost:15672/)  
  Login: `guest / guest`

- **HTTP Pix Request Example:**  
  Send a POST request to:  
  [http://localhost:8080/](http://localhost:8080/pix)

**Request Body:**
```json
{
  "channel": "pf",
  "from": "charles",
  "to": "david",
  "value": 500.00
}
```

## 📝 Final Notes

This project was developed as part of the **BuildRun training sessions**.

- For the official repository and more examples from the training program, visit:  
[https://github.com/buildrun-tech/buildrun-fbr-rabbitmq-pub-sub-routing-key-example](https://github.com/buildrun-tech/buildrun-fbr-rabbitmq-pub-sub-routing-key-example)

- Website for the full training: [https://app.buildrun.com.br/](https://app.buildrun.com.br/)


**Tags:** \`Java\` \`Spring Boot\` \`RabbitMQ\` \`Microservices\` \`Messaging\` \`DLQ\` \`Audit\` \`Event-Driven\` \`Messaging\`
