/*우클릭 방지*/
document.oncontextmenu = function(){return false;}
/*모달*/
const myModal = document.getElementById('myModal')
const myInput = document.getElementById('myInput')

myModal.addEventListener('shown.bs.modal', () => {
    myInput.focus()
})
