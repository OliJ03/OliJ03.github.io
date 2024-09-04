
document.addEventListener("DOMContentLoaded", function() {
    loadBackgroundColor();
    document.getElementById('colorID').addEventListener('input', onBackground);
}
);

function loadBackgroundColor() {
    if(localStorage.storedValue) {
        var storedColor = localStorage.storedValue;
        document.getElementById('colorID').value = storedColor;
        document.body.style.backgroundColor = storedColor;
     }
}
function onBackground() { 
    var backgroundColor = document.getElementById('colorID').value;
    document.body.style.backgroundColor = backgroundColor;
    localStorage.setItem('storedValue', backgroundColor);
}



