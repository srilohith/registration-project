(function () {
    var app = angular.module('app', []);

    app.controller('myCtrl', function ($scope, $http) {

        this.$onInit = function () {
            personcount();
        };

        // employee validation and saving entry time of employee
        $scope.verify = function (personnumber) {
            var data = {
                personnumber: personnumber
            };

            $http.post("http://localhost:8080/api/employee", data) /*posting employee personnumber for validation*/
                .then(function (response) {
                    if (response.data[0] == undefined) {
                        $scope.check = 1;
                    }
                    else {
                        var data = {
                            personnumber: personnumber,
                            entrytime: dateandtime(),
                            exittime: 0
                        };
                        $http.post("http://localhost:8080/api/log/employee", data) /*posting entry time of employee*/
                            .then(function (response) {
                                alert("OK");
                                personcount();
                            })
                            .catch(function (response) {
                                alert("permission denied");
                            });
                    }


                })
        };


        // visitor authentication and saving visitor details and entry time
        $scope.addVisitor = function (visitorname, hostID) {

            var data = {
                visitorname: visitorname,
                hostID: hostID,
                entrytime: dateandtime(),
                exittime: 0
            };

            $scope.check = 0;
            $http.post("http://localhost:8080/api/log", data) /* posting data for visitor entry time into log*/
                .then(function (response) {
                    alert("OK");
                    personcount();
                })
                .catch(function (response) {
                    alert("permission denied");
                });

        };

        // saving exit time of employee
        $scope.employeeexit = function (personnumber) {

            var data = {
                personnumber: personnumber,
                exittime: dateandtime()
            };

            $http.put("http://localhost:8080/api/log/employeeexit", data) /*posting data for employee exit time into log*/
                .then(function (response) {
                    personcount();
                    alert("employee exited")
                })
                .catch(function (response) {
                    alert("invalid personnumber");
                });

        };

        // saving exittime of visitor
        $scope.visitorexit = function (visitorname, hostID) {

            var data = {
                visitorname: visitorname,
                hostID: hostID,
                exittime: dateandtime()
            };

            $http.put("http://localhost:8080/api/log/visitorexit", data) /*posting data for visitor exit time into log*/
                .then(function (response) {
                    personcount();
                    alert("visitor exited")
                })
                .catch(function (response) {
                    alert("invalid visitorname or hostID");
                });


        };


        //date and time function
        dateandtime = function () {
            var currentdate = JSON.stringify(Date());
            return currentdate;
        };

        // counting the number of employees and visitors in the building
        personcount = function () {
            $http.get("http://localhost:8080/api/log")  /*getting list of entries in log table*/
                .then(function (response) {
                    $scope.employeecount = 0;
                    $scope.visitorcount = 0;
                    for (i = 0; i < response.data.length; i++) {
                        if (response.data[i].exittime === '0') {
                            if (response.data[i].personnumber != null) {
                                $scope.employeecount += 1;
                            }
                            else {
                                $scope.visitorcount += 1;
                            }
                        }
                    }

                })
        }


    });

})();


