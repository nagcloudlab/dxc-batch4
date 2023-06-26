
const Rx = require("rxjs");


//----------------------------------------------------
// Trainer
//----------------------------------------------------

const stream = new Rx.Subject();
const trainer = {
    getTopic: function () {
        const promise = new Promise(function (resolve, reject) {
            setTimeout(() => {
                console.log("trainer: resolve/reject promise");
                // let topic = 1
                // resolve(topic)
                // reject(new Error("error"))
            }, 3000);
        })
        return promise
    },
    getTopics() {
        let i = 0;
        let interval = setInterval(() => {
            let topic = ++i
            console.log("trainer propagating change/data/event into stream ( multicast )");
            if (i === 11) {
                stream.complete();
                clearInterval(interval);
            } else {
                stream.next(topic)
            }
        }, 1000);
        return stream;
    }
}


//----------------------------------------------------
// Employee
//----------------------------------------------------

const employee1 = {
    doLearnTopic() {
        console.log("employee: requesting the topic");
        const promise = trainer.getTopic();
        console.log("employee: got promise, defering actions to future");
        promise
            .then(topic => {
                console.log("employee: learning the topic: " + topic);
            })
            .catch(err => {
                console.log("employee: handling err: " + err);
            })
        console.log("employee: cont.. if an work..");
    },
    doLearnTopics() {
        const stream = trainer.getTopics();
        stream
            .pipe(Rx.filter(topic => topic % 2 === 0))
            .pipe(Rx.map(topic => topic * 2))
            .pipe(Rx.bufferCount(2))
            .subscribe({
                next: topic => {
                    console.log("employee1: learning the topic: " + topic);
                },
                error: err => {
                    console.log("employee1: handling err: " + err);
                },
                complete: () => {
                    console.log("employee1: thanks for topics so far");
                }
            })
    }
}

employee1.doLearnTopics();
