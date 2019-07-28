import pl.andrzejkarwoski.query.Query
import pl.andrzejkarwoski.service.QueryService
import spock.lang.Shared
import spock.lang.Specification


class QueryServiceTest extends Specification{

    @Shared
    QueryService queryService

    def setup(){
        queryService = new QueryService()
    }

    def "Empty queryName cause failure result"(){

        given: "empty queryName"
        String queryName = null

        when: "giving response"
        Query query = queryService.getQuery(queryName)

        then: "result is failure"
        assert query == null
    }

}