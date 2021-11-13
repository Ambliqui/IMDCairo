/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/ClientSide/javascript.js to edit this template
 */


btnTarjeta.addEventListener("click", function () {
    tarjeta.checked = true;
    resetRequired();
    numeroTarjeta.required = true;
    mesTarjeta.required = true;
    annoTarjeta.required = true;
});

window.onload = function () {
    tarjeta.checked = true;
    resetRequired();
    numeroTarjeta.required = true;
    mesTarjeta.required = true;
    annoTarjeta.required = true;
};

btnPaypal.addEventListener("click", function () {
    paypal.checked = true;
    resetRequired();
    cuentaPaypal.required = true;
});

btnTransferencia.addEventListener("click", function () {
    transferencia.checked = true;
    resetRequired();
    IBAN.required = true;
});

function resetRequired() {

    numeroTarjeta.required = false;
    mesTarjeta.required = false;
    annoTarjeta.required = false;
    cvsTarjeta.required = false;
    cuentaPaypal.required = false;
    IBAN.required = false;
}