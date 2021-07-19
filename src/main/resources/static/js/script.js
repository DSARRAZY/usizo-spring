// function getFormReq(self){
//     if(canDo){
//         const xhr = new XMLHttpRequest();
//         let url = 'ShopListProduct?id='+self.id;
//         xhr.open('GET', url, true);xhr.onload = function () {
//             document.getElementsByClassName("div-block-29")[0].innerHTML = xhr.responseText
//             document.getElementsByName("wf-form-Product")[0].action="ShopList?id="+sl;
//         };
//         xhr.send(null);
//     }
// }

function getList(self){
    const xhr = new XMLHttpRequest();
    let url = 'getList?id='+self.id;
    xhr.open('GET', url, true);xhr.onload = function () {
        document.querySelector("#shopping-list-details").innerHTML = xhr.responseText
    };
    xhr.send(null);
}

// function remNeed(self) {
//     canDo = false;
//     var data = {id:sl,idP:self};
//     var XHR = new XMLHttpRequest();
//     var urlEncodedData = "";
//     var urlEncodedDataPairs = [];
//     var name;
//     for(name in data) {
//         urlEncodedDataPairs.push(encodeURIComponent(name) + '=' + encodeURIComponent(data[name]));
//     }
//     urlEncodedData = urlEncodedDataPairs.join('&').replace(/%20/g, '+');
//     XHR.addEventListener('load', function(event) {
//         window.location = "shoppingListManager?id="+sl;
//     });
//     XHR.open('POST', 'remNeed');
//     XHR.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
//     XHR.send(urlEncodedData);
// }
//

function modList(id){
    window.location = "ShopList?id="+id;
}

function addList(id){
    window.location = "addList?id="+id;
}

function remList(id,idL){
    window.location = "remList?id="+id+"&idL="+idL;
}