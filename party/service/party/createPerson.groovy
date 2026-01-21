// 1. Validate required fields
if (!partyId) {
    ec.message.addError("partyId is required")
}
if (!firstName) {
    ec.message.addError("firstName is required")
}
if (!lastName) {
    ec.message.addError("lastName is required")
}

// Stop execution if validation failed
if (ec.message.hasError()) {
    return
}

// 2. Check if Party exists
def party = ec.entity.find("party.Party")
        .condition("partyId", partyId)
        .one()

if (!party) {
    ec.message.addError("Party with partyId ${partyId} does not exist")
    return
}

// 3. Create Person entity
def person = ec.entity.makeValue("party.Person")

// Copy all input parameters (including optional ones)
person.setFields(context, true, null, null)

// Ensure correct partyId
person.partyId = partyId

// 4. Create record
person.create()

// 5. Prepare response
responseMessage = "Person ${firstName} ${lastName} created successfully!"
