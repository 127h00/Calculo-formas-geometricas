function calculateVolume() {
    var edgeLength = document.getElementById('edgeLength').value;
    var result = document.getElementById('result');
    var error = document.getElementById('error');
    error.textContent = '';
    result.textContent = '';

    if (isNaN(edgeLength) || edgeLength == '') {
        error.textContent = 'Por favor, insira um número válido.';
    } else {
        var volume = Math.pow(parseFloat(edgeLength), 3);
        result.textContent = 'O volume do cubo é: ' + volume.toFixed(2) + ' m³';
    }
}