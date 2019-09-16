package groovy

class HttpUtil {
    def test() {
        httpRequest(
                httpMode: "GET",
                ignoreSslErrors: true,
                url: "www.baidu.com",
                contentType: "APPLICATION_JSON"
        )
    }

    def updateStatus() {
        if (params['requestType'] == 'BuildCluster') {
            // update status in SoaClusterRequest
            httpRequest(
                    httpMode: "POST",
                    ignoreSslErrors: true,
                    url: "${params['slm_instance']}/request/cluster/request_status?requestId=${params['requestId']}&status=1",
                    contentType: "APPLICATION_JSON"
            )
            // update jenkins job url in SoaClusterRequest
            httpRequest(
                    httpMode: "POST",
                    ignoreSslErrors: true,
                    url: "${params['slm_instance']}/request/cluster/jenkins_job_url?requestId=${params['requestId']}&jenkins_job_url=${BUILD_URL}",
                    contentType: "APPLICATION_JSON"
            )
        }
    }

    static void main(String[] args) {
        Student st = new Student();
        st.StudentID = 1;
        st.StudentName = "Joe";

        st.Marks1 = 10;
        st.Marks2 = 20;
        st.Marks3 = 30;

        println(st.Total());

        HttpUtil util = new HttpUtil();
        println(util.test());

    }

}