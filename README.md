# 🧩 Party Component — Hotwax Moqui Assignment

This repository contains the **custom Party component** developed as part of the **Hotwax Commerce Moqui Framework Assignment**.

The purpose of this component is to model **People, Organizations, and their Contact Information** in a clean, extensible way using Moqui’s Entity Engine.

---

## 📌 Assignment Objective

To create a reusable **Party component** that supports:

- Persons  
- Organizations (Party Groups)  
- Contact mechanisms (Email, Phone, Address)  
- Relationships between Parties and Contact Mechanisms  

The component was built following the official Hotwax assignment specification.

---

---

## 🧩 Entities Implemented

### 1️⃣ Party  
Represents any person or organization.

| Field | Type | Description |
|------|------|-------------|
| partyId | id | Primary Key |
| partyTypeEnumId | id | PERSON or PARTY_GROUP |
| createdDate | date-time | When the party was created |

---

### 2️⃣ Person  
Stores details of individuals.

| Field | Type |
|------|------|
| partyId | id (PK, FK to Party) |
| firstName | text |
| lastName | text |
| dateOfBirth | date |

---

### 3️⃣ PartyGroup  
Stores details of organizations.

| Field | Type |
|------|------|
| partyId | id (PK, FK to Party) |
| groupName | text |
| description | text |

---

### 4️⃣ ContactMech  
Stores contact details like email and phone.

| Field | Type |
|------|------|
| contactMechId | id (PK) |
| contactMechTypeEnumId | id (EMAIL, TELECOM_NUMBER, POSTAL_ADDRESS) |
| infoString | text |
| createdDate | date-time |

---

### 5️⃣ PartyContactMech  
Links Parties to their contact methods.

| Field | Type |
|------|------|
| partyId | id |
| contactMechId | id |
| fromDate | date-time |
| thruDate | date-time |

Primary Key: `(partyId, contactMechId, fromDate)`

---

## 🧬 Enumerations

Defined in `PartyEnumData.xml`

### Party Type
- PERSON  
- PARTY_GROUP  

### Contact Mechanism Type
- EMAIL  
- TELECOM_NUMBER  
- POSTAL_ADDRESS  

---

## 🧪 Seed Data

Defined in `PartySeedData.xml`

Sample records created:

- Person: **Amit Sharma**
- Organization: **Hotwax Commerce**
- Email: **amit@hotwax.com**
- Phone: **+91 9999999999**
- PartyContactMech links for the person

---

## 🖥 Testing in Moqui

The component was tested using:

- **Moqui Entity Tools**
- **Moqui Data Import**
- **MySQL database**

All entities were verified to be:
- Correctly created
- Properly linked
- Seed data successfully inserted

---

## 🚀 How to Use

1. Copy this `party` component into:
   ```
   runtime/component/party
   ```

2. The component is already configured via:
   ```
   party/component.xml
   
   ```


3. Run:
   ```
   gradlew load
   ```
   ```
   gradlew run
   ```

4. Open Moqui UI → Entity Tools → Verify and test

---

## 📌 Author

**Dishika Mewada**  
B.Tech Final Year  
Java Backend Developer  
