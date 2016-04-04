<?php
$output = array(
    "status" => 0
);

header('Access-Control-Allow-Headers: Content-type');  
header('Access-Control-Allow-Methods: GET, POST');  
header('Access-Control-Allow-Origin: *');
header('Content-type: application/json');

if(isset($_POST['user']) && isset($_POST['password']) && isset($_POST['newpassword'])) {
    $user = $_POST['user'];
    $password = $_POST['password'];
    $newpassword = $_POST['newpassword'];
    $str = file_get_contents('users.json');
    $json = json_decode($str, true);

    if(array_key_exists($user,$json))
    {
        if($json[$user]!=""&&$json[$user]!=null)
        {
            if($password == $json[$user]['password']) {
                if($newpassword!=""&&$newpassword!=null)
                {
                    $output['status'] = 1;
                    $json[$user]['password']=$newpassword;
                    $newJson = json_encode($json,JSON_PRETTY_PRINT);
                    file_put_contents('users.json', $newJson);
                }
            }
        }
    }
}



echo json_encode($output);
?>