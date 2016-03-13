<?php
$output = array(
        "status" => 0
);

if(isset($_POST['user']) && isset($_POST['password'])) {
    $user = $_POST['user'];
    $password = $_POST['password'];
    
    $str = file_get_contents('users.json');
    $json = json_decode($str, true);
    if($password == $json[$user]['password']) {
        $output['status'] = 1;
        $output['courriel'] = $json[$user]['courriel'];
        $output['prenom'] = $json[$user]['prenom'];
        $output['nom'] = $json[$user]['nom'];
        $output['codepermanent'] = $json[$user]['codepermanent'];
        $output['codems'] = $json[$user]['codems'];
    }
}

header('Content-type: application/json');
echo json_encode($output);
?>
