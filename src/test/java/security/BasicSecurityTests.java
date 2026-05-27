package security;

@Epic("Security")
@Feature("Headers")
public class BasicSecurityTests extends BaseApiTest {
    @Test
    void securityHeaders_present() {
        given().when()
                .get("/")
                .then()
                .header("Content-Security-Policy", notNullValue())
                .header("X-Content-Type-Options", anyOf(equalTo("nosniff"), notNullValue()))
                .header("X-Frame-Options", anyOf(equalTo("DENY"), equalTo("SAMEORIGIN"), notNullValue()));
    }
}
