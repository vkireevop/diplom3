document.getElementById('signup-form').addEventListener('submit', function(event) {
    event.preventDefault();
    var username = document.getElementById('username').value;
    var email = document.getElementById('email').value;
    var password = document.getElementById('password').value;

    fetch('/auth/sign-up', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({
            username: username,
            email: email,
            password: password
        })
    })
    .then(response => response.json())
    .then(data => {
        if (data.token) {
            // Сохранение токена и перенаправление на главную страницу
            localStorage.setItem('token', data.token);
            window.location.href = '/';
        } else {
            // Обработка ошибок
            alert('Ошибка регистрации: ' + data.message);
        }
    })
    .catch(error => {
        console.error('Ошибка:', error);
    });
});

document.getElementById('signin-form').addEventListener('submit', function(event) {
    event.preventDefault();
    var username = document.getElementById('username').value;
    var password = document.getElementById('password').value;

    fetch('/auth/sign-in', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({
            username: username,
            password: password
        })
    })
    .then(response => response.json())
    .then(data => {
        if (data.token) {
            // Сохранение токена и перенаправление на главную страницу
            localStorage.setItem('token', data.token);
            window.location.href = '/';
        } else {
            // Обработка ошибок
            alert('Ошибка авторизации: ' + data.message);
        }
    })
    .catch(error => {
        console.error('Ошибка:', error);
    });
});