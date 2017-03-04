//定义画布宽和高
var WINDOW_WIDTH = 1024;
var WINDOW_HEIGHT = 768;
//定义数字点阵圆圈半径
var RADIUS = 8;
//计时器距离画布上边缘间距
var MARGIN_TOP = 150;
//计时器各个数字间距
var MARGIN_LEFT = 30;
const endTime = new Date(2017, 1, 27, 18, 47, 52);
//需要显示的总秒数，用作计时器是需要此变量
//var curShowTimeSeconds = 0;
//当前系统时间，用作时钟时需要此变量
var curDate;
//动画效果小球集合
var balls = [];
//小球随机色集合
var colors = ["#33B5E5", "#AA66CC", "#9933CC", "#669900", "#808A87"
				, "#FCE6C9", "#FF0000", "#FF6347", "#FF00FF", "#00FF00"
				, "#6B8E23", "#0000FF", "#00C78C", "#FFFF00", "#FF9912"
				, "#FFD700", "#FF8000", "#BC8F8F", "#A020F0", "#DA70D6"
				, "#8A2BE2", "#F4A460"];

window.onload = function() {
	//屏幕自适应相关
	WINDOW_WIDTH = document.body.clientWidth;
	WINDOW_HEIGHT = document.documentElement.clientHeight;
	MARGIN_LEFT = Math.round(WINDOW_WIDTH / 10);
	RADIUS = Math.round(WINDOW_WIDTH * 0.8 / 108) - 1;
	MARGIN_TOP = Math.round(WINDOW_HEIGHT / 5);

	var canvas = document.getElementById("canvas");
	var context = canvas.getContext("2d");

	canvas.width = WINDOW_WIDTH;
	canvas.height = WINDOW_HEIGHT;
	//curShowTimeSeconds = getcurShowTimeSeconds();//此段用于计时器功能
	curDate = getCurDate(); //此段用于时钟功能
	//重复调用实现动画效果
	setInterval(
		function() {
			render(context);
			update();
		},
		50
	);
}

//时间逐帧更新
function update() {
	/***
	此段用于计时器功能
	var nextShowTimeSeconds = getcurShowTimeSeconds();
	var nextHours = parseInt(nextShowTimeSeconds / 3600);
	var nextMinites = parseInt((nextShowTimeSeconds - nextHours * 3600) / 60);
	var nextSeconds = nextShowTimeSeconds % 60;

	var curHours = parseInt(curShowTimeSeconds / 3600);
	var curMinites = parseInt((curShowTimeSeconds - curHours * 3600) / 60);
	var curSeconds = curShowTimeSeconds % 60;
	**/

	//此段用于时钟功能
	var nextDate = getCurDate();
	var nextHours = nextDate.getHours();
	var nextMinites = nextDate.getMinutes();
	var nextSeconds = nextDate.getSeconds();

	var curHours = curDate.getHours();
	var curMinites = curDate.getMinutes();
	var curSeconds = curDate.getSeconds();

	//秒针
	if (nextSeconds != curSeconds) {
		//秒钟两个数字彩色小球是否要创建逻辑
		if (parseInt(curSeconds / 10) != parseInt(nextSeconds / 10)) {
			createBallsByNumber(MARGIN_LEFT + 78 * (RADIUS + 1), MARGIN_TOP, parseInt(curSeconds / 10));
		}
		if (parseInt(curSeconds % 10) != parseInt(nextSeconds % 10)) {
			createBallsByNumber(MARGIN_LEFT + 93 * (RADIUS + 1), MARGIN_TOP, parseInt(curSeconds % 10));
		}
		//curShowTimeSeconds = nextShowTimeSeconds;//此段用于计时器	
	}

	//分针
	if (nextMinites != curMinites) {
		//分钟两个数字小球渲染与否逻辑
		if (parseInt(curMinites / 10) != parseInt(nextMinites / 10)) {
			createBallsByNumber(MARGIN_LEFT + 39 * (RADIUS + 1), MARGIN_TOP, parseInt(curMinites / 10));
		}
		if (parseInt(curMinites % 10) != parseInt(nextMinites % 10)) {
			createBallsByNumber(MARGIN_LEFT + 54 * (RADIUS + 1), MARGIN_TOP, parseInt(curMinites % 10));
		}
		//curShowTimeSeconds = nextShowTimeSeconds;//此段用于计时器	
	}

	//时针
	if (nextHours != curHours) {
		//时钟两个数字小球渲染与否逻辑
		if (parseInt(curHours / 10) != parseInt(nextHours / 10)) {
			createBallsByNumber(MARGIN_LEFT, MARGIN_TOP, parseInt(curHours / 10));
		}
		if (parseInt(curHours % 10) != parseInt(nextHours % 10)) {
			createBallsByNumber(MARGIN_LEFT + 15 * (RADIUS + 1), MARGIN_TOP, parseInt(curHours % 10));
		}
		//curShowTimeSeconds = nextShowTimeSeconds;//此段用于计时器	
	}

	curDate = nextDate; //此段用于时钟
	updateBalls();
}


//更新小球动作
function updateBalls() {
	for (var i = 0; i < balls.length; i++) {
		balls[i].x += balls[i].vx;
		balls[i].y += balls[i].vy;
		balls[i].vy += balls[i].g;

		//地板碰撞检测
		if (balls[i].y >= WINDOW_HEIGHT - RADIUS) {
			balls[i].y = WINDOW_HEIGHT - RADIUS;
			balls[i].vy = -balls[i].vy * 0.75;
		}

	}

	//内存优化，防止彩色小球堆积导致balls数组过大引起内存溢出
	//cnt为计数器，对可视边界内小球个数进行计数
	//通过左右边界检测，将可视边界内的小球往数组头部上浮
	//下沉的数组元素为可视边界外小球，pop出数组
	var cnt = 0;
	for (var i = 0; i < balls.length; i++) {
		if (balls[i].x + RADIUS > 0 && balls[i].x - RADIUS < WINDOW_WIDTH) {
			balls[cnt++] = balls[i];
		}
	}

	while (balls.length > cnt) {
		balls.pop();
	}
}

//生成彩色小球，存储进数组等待渲染
function createBallsByNumber(x, y, num) {
	for (var i = 0; i < digit[num].length; i++) {
		for (var j = 0; j < digit[num][i].length; j++) {
			if (digit[num][i][j] == 1) {
				var aBall = {
					x: x + j * 2 * (RADIUS + 1) + (RADIUS + 1),
					y: y + i * 2 * (RADIUS + 1) + (RADIUS + 1),
					g: 1.5 + Math.random(),
					vx: Math.pow(-1, Math.ceil(Math.random() * 1000)) * 4,
					vy: -5 + Math.pow(-1, Math.ceil(Math.random() * 1000)) * Math.random(),
					color: colors[Math.floor(Math.random() * colors.length)]
				}
				balls.push(aBall);
			}
		}
	}
}


//渲染
function render(cxt) {
	//刷新画布
	cxt.clearRect(0, 0, WINDOW_WIDTH, WINDOW_HEIGHT);

	//var hours = parseInt(curShowTimeSeconds / 3600);
	//var minites = parseInt((curShowTimeSeconds - hours * 3600) / 60);
	//var seconds = curShowTimeSeconds % 60;
	//
	var hours = curDate.getHours();
	var minites = curDate.getMinutes();
	var seconds = curDate.getSeconds();

	renderDigit(MARGIN_LEFT, MARGIN_TOP, parseInt(hours / 10), cxt); //绘制小时第一个数据
	renderDigit(MARGIN_LEFT + 15 * (RADIUS + 1), MARGIN_TOP, parseInt(hours % 10), cxt); //绘制小时第二个数据
	renderDigit(MARGIN_LEFT + 30 * (RADIUS + 1), MARGIN_TOP, 10, cxt); //绘制冒号
	renderDigit(MARGIN_LEFT + 39 * (RADIUS + 1), MARGIN_TOP, parseInt(minites / 10), cxt); //绘制分钟第一个数据
	renderDigit(MARGIN_LEFT + 54 * (RADIUS + 1), MARGIN_TOP, parseInt(minites % 10), cxt); //绘制分钟第二个数据
	renderDigit(MARGIN_LEFT + 69 * (RADIUS + 1), MARGIN_TOP, 10, cxt); //绘制冒号
	renderDigit(MARGIN_LEFT + 78 * (RADIUS + 1), MARGIN_TOP, parseInt(seconds / 10), cxt); //绘制秒钟第一个数据
	renderDigit(MARGIN_LEFT + 93 * (RADIUS + 1), MARGIN_TOP, parseInt(seconds % 10), cxt); //绘制秒钟第二个数据

	renderBalls(cxt);
}

//渲染彩色小球
function renderBalls(cxt) {
	//遍历balls数组渲染彩色小球
	for (var i = 0; i < balls.length; i++) {
		cxt.fillStyle = balls[i].color;
		cxt.beginPath();
		cxt.arc(balls[i].x, balls[i].y, RADIUS, 0, 2 * Math.PI, true);
		cxt.closePath();
		cxt.fill();
	}
}


//渲染数字
function renderDigit(x, y, num, cxt) {
	cxt.fillStyle = "rgb(0,102,153)";
	for (var i = 0; i < digit[num].length; i++) {
		for (var j = 0; j < digit[num][i].length; j++) {
			if (digit[num][i][j] == 1) {
				cxt.beginPath();
				cxt.arc(x + j * 2 * (RADIUS + 1) + (RADIUS + 1), y + i * 2 * (RADIUS + 1) + (RADIUS + 1), RADIUS, 0, 2 * Math.PI);
				cxt.closePath();

				cxt.fill();
			}
		}
	}
}


//获取当前显示时间的秒数
function getcurShowTimeSeconds() {
	var curTime = new Date();
	var ret = endTime.getTime() - curTime.getTime();
	ret = Math.round(ret / 1000);
	//ret = 3789;
	return ret >= 0 ? ret : 0;
}

//获取当前系统的时间，做时钟用
function getCurDate() {
	return new Date();
}