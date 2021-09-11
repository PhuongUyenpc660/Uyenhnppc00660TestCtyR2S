app.controller('account-ctrl', function ($scope, $http) {
	$scope.items = [];
	$scope.form = {};
	$scope.cates = [];
	$scope.initialize = function () {

		// load user
		$http.get('/rest/accounts').then(function (response) {
			$scope.items = response.data;
		});

		// load user
		$http.get('/rest/accounts').then(function (response) {
			$scope.cates = response.data;
		});

	}

	$scope.initialize();

	$scope.reset = function () {
		$scope.form = {
			image: 'cloud-upload.jpg',
		};
	}
	// Hiển thị user lên form
	$scope.edit = function (item) {
		$scope.form = angular.copy(item);
		$(".nav-tabs a:eq(0)").tab('show');

	}
	// Cập nhật tai khoan 

	$scope.update = function () {
		var item = angular.copy($scope.form);
		$http.put(`/rest/accounts/${item.username}`, item).then(function (response) {
			var index = $scope.items.findIndex(p => p.username == item.username);
			$scope.items[index] = item;
			alert('Cập nhật thành công');
		}).catch(function (err) {
			alert('Lỗi cập nhật tài khoản');
			console.log("Erorr", err);
		})


	}
	// Thêm user
	$scope.create = function () {
		var item = angular.copy($scope.form);
		$http.post('/rest/accounts', item).then(function (response) {
			response.data.createDate = new Date(response.data.createDate);
			$scope.items.push(response.data);
			$scope.reset();
			alert('Thêm mới thành công');

		}).catch(error => {
			alert('Lỗi thêm mới tài khoản');
			console.log("Erorr", error);
		})

	}

	// Xóa user 
	$scope.delete = function (item) {
		$http.delete(`/rest/accounts/${item.username}`).then(function (response) {
			var index = $scope.items.findIndex(p => p.username == item.username);
			$scope.items.splice(index, 1);
			$scope.reset();
			alert('Xóa thành công');

		}).catch(function (err) {
			alert('Lỗi xóa sản phẩm');
			console.log("Erorr", err);
		})
	}

	$scope.imageChange = function (files) {
		var data = new FormData();
		data.append("file", files[0]);
		$http.post('/rest/upload/images', data, {
			transformRequest: angular.entity,
			headers: {
				'Content-Type': undefined
			}
		}).then(response => {
			$scope.form.photo = response.data.name; //đường dẫn của file
		}).catch(err => {
			alert("Lỗi hình ảnh");
			console.log("Erorr", err);
		})

	}

	$scope.pager = {
		page: 0,
		size: 10,
		get items() {
			var start = this.page * this.size;
			return $scope.items.slice(start, start + this.size);
		},
		get count() {
			return Math.ceil(1.0 * $scope.items.length
				/ this.size);
		},
		first() {
			this.page = 0;

		},
		pre() {
			this.page--;
			if (this.page < 0) {
				this.last();
			}
		},
		next() {
			this.page++;
			if (this.page >= this.count) {
				this.first();
			}
		},
		last() {
			this.page = this.count - 1;
		},
	}
});