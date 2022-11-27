<?php

    if($_SERVER['REQUEST_METHOD'] == 'POST'){
        include "db.php";

        $conectar = new DB();
    
        $nombre = $_POST['nombre'];
        $apellidos = $_POST['apellidos'];
        $edad = $_POST['edad'];
        $sexo = $_POST['sexo'];
        $pais = $_POST['pais'];
        $estado = $_POST['estado'];
        $telefono = $_POST['telefono'];
        $correo = $_POST['correo'];
    
        $sql = $conectar->connect()->prepare('INSERT INTO tbl_Registro (nombre, apellidos, edad, sexo, pais, estado, telefono, correo) VALUES (:nombre, :apellidos, :edad, :sexo, :pais, :estado, :telefono, :correo)');
    
        $sql->bindParam(':nombre', $nombre, PDO::PARAM_STR);
        $sql->bindParam(':apellidos', $apellidos, PDO::PARAM_STR);
        $sql->bindParam(':edad', $edad, PDO::PARAM_STR);
        $sql->bindParam(':sexo', $sexo, PDO::PARAM_STR);
        $sql->bindParam(':pais', $pais, PDO::PARAM_STR);
        $sql->bindParam(':estado', $estado, PDO::PARAM_STR);
        $sql->bindParam(':telefono', $telefono, PDO::PARAM_STR);
        $sql->bindParam(':correo', $correo, PDO::PARAM_STR);
    
        $result = $sql->execute();

    }
    
?>