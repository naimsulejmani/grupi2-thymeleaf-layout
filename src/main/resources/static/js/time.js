const loadedTime = document.getElementById("loadedTime");
const realTime = document.getElementById("realTime");
const time = new Date().toISOString();
console.log(time);
loadedTime.innerText = time;

function realTimeFunction() {
    realTime.innerText = new Date().toISOString();
}

const SECOND = 1000;
const MINUTE = 60 * SECOND;
const HOUR = 60 * MINUTE;
const DAY = 24 * HOUR;
const WEEK = 7 * DAY;

setInterval(realTimeFunction, SECOND);

function showTimeAlert() {
    alert("Time is: " + new Date().toISOString());
}


setTimeout(showTimeAlert, 5 * SECOND)
















