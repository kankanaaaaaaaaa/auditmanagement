// export const Microservices : {[key: string]: string} = {
//     // give like this : 
//     // "ms-name" : "http://localhost:[port-no.]/[context-root]"
//     "auth"      : "http://localhost:8100/auth",
//     "checklist" : "http://localhost:8200/checklist",
//     "benchmark" : "http://localhost:8250/benchmark",
//     "severity"  : "http://localhost:8300/severity"
// }
export const Microservices : {[key: string]: string} = {
    // give like this : 
    // "ms-name" : "http://localhost:[port-no.]/[context-root]"
    "auth"      : "http://localhost:9191/auth",
       
    "checklist" : "http://localhost:9191/checklist",
    // "checklist" : "AUDUT-CHECKLIST/",
    "benchmark" : "http://localhost:9191/benchmark",
    // "benchmark" : "AUDIT-BENCHMARK/",
    "severity"  : "http://localhost:9191/severity"
    // "severity"  : "AUDUT-SEVERITY/"
    
}