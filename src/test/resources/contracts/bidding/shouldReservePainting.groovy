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
                "artworkId": "123",
                "buyer": "Ben Johnson"
        )
    }


    response {
        status 200
        headers {
            contentType(applicationJson())
        }
        body(
                "status":"OK"
        )
    }
}
