package contracts.bidding

import org.springframework.cloud.contract.spec.Contract

Contract.make {
    request {
        description("""
            Minimal happy trail: reserve successfully
        """)

        method 'POST'
        url '/reserve'
        headers {
            contentType(applicationJson())
        }
        body (
                "artworkId": value(consumer(regex("[0-9]+")))
        )
    }


    response {
        status 200
        headers {
            contentType(applicationJson())
        }
        body(
                "status":"OK",
		"reservationId": anyNumber()
        )
    }
}
