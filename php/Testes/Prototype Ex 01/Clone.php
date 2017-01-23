<?php
//Clone.php
abstract class CloneMe {
	public $name;
	public $picture;
	abstract function _clone();
}

class Person extends CloneMe {
	public function _construct() {
		$this->picture="Clone.png";
		$this->name="Original";
	}
	public function display() {
		echo "<img src= '$this->picture' weigth=400 height=400>";
		echo "<br/>$this->name<p />";
	}
	function _clone() {}
}
$worker=new Person();
$worker->_construct();
$worker->display();
$slacker = clone $worker;
$slacker->name="Cloned";
$slacker->display();
?>