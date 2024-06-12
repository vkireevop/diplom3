const stikhiButton = document.getElementById("stikhi-button");
const conceptualthinkingButton = document.getElementById("conceptual-thinking-button");
const installationsButton = document.getElementById("installations-button");
const resultButton = document.getElementById("result-button");

stikhiButton.addEventListener("click", () => {
    window.location.href = stikhiButton.getAttribute("data-href");
});

conceptualthinkingButton.addEventListener("click", () => {
    window.location.href = conceptualthinkingButton.getAttribute("data-href");
});

installationsButton.addEventListener("click", () => {
    window.location.href = installationsButton.getAttribute("data-href");
});

resultButton.addEventListener("click", () => {
    window.location.href = resultButton.getAttribute("data-href");
});