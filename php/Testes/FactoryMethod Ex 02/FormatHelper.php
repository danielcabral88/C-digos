<?php
//FormatHelper.php
class FormatHelper {
	private $topper;
	private $botton;
	public function addTop(){
		$this->topper = "<!doctype html><html><head>
		<link rel='stylesheet' type='text/css' href='products.css'/>
		<meta charset='UTF-8'>
		<title> Map Factory </title>
		</head>
		<body>";
		return $this->topper;
	}
	public function closeUp(){
		$this->botton="</body></html>";
		return $this->botton;
	}
}
?>