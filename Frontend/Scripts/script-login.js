const loginForm = document.getElementById('loginForm');
const registrationForm = document.getElementById('registrationForm');

const showLoginBtn = document.getElementById('showLoginBtn');
const showRegistrationBtn = document.getElementById('showRegistrationBtn');

showLoginBtn.addEventListener('click', function() {
    loginForm.style.display = 'block';
    registrationForm.style.display = 'none';
});

showRegistrationBtn.addEventListener('click', function() {
    loginForm.style.display = 'none';
    registrationForm.style.display = 'block';
});

const submitButton = document.getElementById("submit-button");

submitButton.addEventListener('click', function() {
    window.location.href = submitButton.getAttribute("data-href");
});