const base = {
    get() {
        return {
            url : "http://localhost:8080/xiaoquwuyezhinengka/",
            name: "xiaoquwuyezhinengka",
            // 退出到首页链接
            indexUrl: 'http://localhost:8080/xiaoquwuyezhinengka/front/index.html'
        };
    },
    getProjectName(){
        return {
            projectName: "小区物业智能卡管理"
        } 
    }
}
export default base
