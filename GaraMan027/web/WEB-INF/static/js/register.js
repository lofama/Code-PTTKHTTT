var current = null;
document.querySelector('#name').addEventListener('focus', function(e) {
  if (current) current.pause();
  current = anime({
    targets: 'path',
    strokeDashoffset: {
      value: 0,
      duration: 350,
      easing: 'easeOutQuart'
    },
    strokeDasharray: {
      value: '240 2500',
      duration: 700,
      easing: 'easeOutQuart'
    }
  });
});
document.querySelector('#email').addEventListener('focus', function(e) {
  if (current) current.pause();
  current = anime({
    targets: 'path',
    strokeDashoffset: {
      value: -336,
      duration: 700,
      easing: 'easeOutQuart'
    },
    strokeDasharray: {
      value: '240 2500',
      duration: 700,
      easing: 'easeOutQuart'
    }
  });
});
document.querySelector('#password').addEventListener('focus', function(e) {
  if (current) current.pause();
  current = anime({
    targets: 'path',
    strokeDashoffset: {
      value: -672,
      duration: 700,
      easing: 'easeOutQuart'
    },
    strokeDasharray: {
      value: '240 2500',
      duration: 240,
      easing: 'easeOutQuart'
    }
  });
});
document.querySelector('#confirm-password').addEventListener('focus', function(e) {
    if (current) current.pause();
    current = anime({
      targets: 'path',
      strokeDashoffset: {
        value: -1008,
        duration: 700,
        easing: 'easeOutQuart'
      },
      strokeDasharray: {
        value: '240 2500',
        duration: 240,
        easing: 'easeOutQuart'
      }
    });
});
document.querySelector('#submit').addEventListener('focus', function(e) {
    if (current) current.pause();
    current = anime({
      targets: 'path',
      strokeDashoffset: {
        value: -1699,
        duration: 700,
        easing: 'easeOutQuart'
      },
      strokeDasharray: {
        value: '482 2500',
        duration: 700,
        easing: 'easeOutQuart'
      }
    });
  });
  function checkPasswordMatch() {
    var password = document.getElementById("password").value;
    var confirmPassword = document.getElementById("confirm-password").value;
    var message = document.getElementById("password-match-message");

    if (password != confirmPassword) {
      message.innerHTML = "Passwords do not match!";
    } else {
      message.innerHTML = "";
    }
  }

  function validateForm() {
    var password = document.getElementById("password").value;
    var confirmPassword = document.getElementById("confirm-password").value;

    if (password != confirmPassword) {
      alert("Mật khẩu nhập lại không đúng!");
      return false;
    }

    return true;
  }