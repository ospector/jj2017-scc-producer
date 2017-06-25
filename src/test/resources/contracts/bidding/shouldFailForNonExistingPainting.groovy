package contracts.bidding

import org.springframework.cloud.contract.spec.Contract

Contract.make {
    request {
        description("""
            Attempt to reserve non existing painting will fail
        """)

        method 'POST'
        url '/reserve'
        headers {
            contentType(applicationJson())
        }
        body (
                "artworkId": "no-such-painting",
                "buyer": "Ben Johnson"
        )
    }


    response {
        status 200
        headers {
            contentType(applicationJson())
        }
        body(
                "status":"NOT_AVAILABLE"
        )
    }
}
