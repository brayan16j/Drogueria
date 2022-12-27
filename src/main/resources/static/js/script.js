
$(document).ready(function (){
    getProductosList();
    getClienteList();
});

function getFrontProductoData(){
    let k={
        id:$("#id").val(),
        nombre:$("#nombre").val(),
        tipo:$("#tipo").val(),
        stock:$("#stock").val(),
        stockMinimo:$("#stockMinimo").val(),
        precio:$("#precio").val()
    }
    return k;
}
function cleanFields(){
    $("#id").val("");
    $("#nombre").val("");
    $("#tipo").val("");
    $("#stock").val("");
    $("#stockMinimo").val("");
    $("#precio").val("");


}

function getClienteList(){
    $.ajax({
        url:"/api/cliente/all",
        type:"GET",
        datatype: "JSON",
        success: function(p){
            console.log(p);
        },
        error: function (xhr, status){
            alert('ha sucedido un problema')
        },
        complete: function (xhr, status){
            //alert('Peticion Realizada')
        }
    });
}

function saveProducto(){
    let data = getFrontProductoData();
    data.id=null;
    let dataToSend=JSON.stringify(data)
    $.ajax({
        url:"/api/producto/save",
        type:"POST",
        datatype: "JSON",
        contentType:'application/json',
        data:dataToSend,
        success: function(p){
            console.log(p);
            cleanFields();
            getProductosList();
        },
        error: function (xhr, status){
            //alert('ha sucedido un problema')
        },
        complete: function (xhr, status){
            //alert('Peticion Realizada')
        }
    });
}


function getProductosList(){
    $.ajax({
        url:"/api/producto/all",
        type:"GET",
        datatype: "JSON",
        success: function(p){
           console.log(p);
           $("#results").empty();
           let l ="";
           for (let i=0; i<p.length; i++){
               l+=` 
                   <div class="col">
                            <div class="card"><div class="card-header">
                                    <h5 class="card-title">${p[i].nombre}</h5>
                            </div>
                           <!--<img src="..." class="card-img-top" alt="...">-->
                               <div class="card-body">
                                   <p class="card-text">Tipo: ${p[i].tipo}</p>
                                   <p class="card-text">Stock: ${p[i].stock}</p>
                                   <p class="card-text">Stock Minimo: ${p[i].stockMinimo}</p>
                                   <p class="card-text">Precio: ${p[i].precio}</p>
                               </div>
                               <div class="card-footer">
                                    <button type="button" class="btn btn-outline-primary" onclick="getProductoById(${p[i].id})">Actualizar</button>
                                    <button type="button" class="btn btn-outline-primary" onclick="deleteProductoById(${p[i].id})">Eliminar</button>
                                            
                               </div>
                       </div>
                   </div>
                   `;
           }
           $("#results").append(l);

        },
        error: function (xhr, status){
            //alert('ha sucedido un problema')
        },
        complete: function (xhr, status){
            //alert('Peticion Realizada')
        }
    });
}

function getProductoById(idProducto){
    $(".saveButtonJL").hide();
    $(".updateButtonJL").show();
    $.ajax({
        url:"/api/producto/"+idProducto,
        type:"GET",
        datatype: "JSON",
        success: function(p){
            console.log(p);
            $("#id").val(p.id);
            $("#nombre").val(p.nombre);
            $("#tipo").val(p.tipo);
            $("#stock").val(p.stock);
            $("#stockMinimo").val(p.stockMinimo);
            $("#precio").val(p.precio);

        },
        error: function (xhr, status){
            //alert('ha sucedido un problema')
        },
        complete: function (xhr, status){
            //alert('Peticion Realizada')
        }
    });
}
function updateProducto(){
    let data = getFrontProductoData();

    let dataToSend=JSON.stringify(data)
    $.ajax({
        url:"/api/producto/update",
        type:"PUT",
        datatype: "JSON",
        contentType:'application/json',
        data:dataToSend,
        success: function(p){
            console.log(p);
            cleanFields();
            getProductosList();
            $(".saveButtonJL").show();
            $(".updateButtonJL").hide();
        },
        error: function (xhr, status){
            //alert('ha sucedido un problema')
        },
        complete: function (xhr, status){
            //alert('Peticion Realizada')
        }
    });
}
function cancelUpdateProducto(){
    cleanFields();
    $(".saveButtonJL").show();
    $(".updateButtonJL").hide();
}
function deleteProductoById(idProducto){
    $.ajax({
        url:"/api/producto/"+idProducto,
        type:"DELETE",
        datatype: "JSON",
        success: function(p){
           console.log(p);
           getProductosList();
        },
        error: function (xhr, status){
            //alert('ha sucedido un problema')
        },
        complete: function (xhr, status){
            //alert('Peticion Realizada')
        }
    });
}