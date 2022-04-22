<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">

<head>
    <meta charset="utf-8">
    <meta http-equiv="x-ua-compatible" content="ie=edge">
    <title>All Expenses</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <!--<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>-->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Open+Sans:100,300,400&display=swap">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.7.2/font/bootstrap-icons.css">
    <link rel="stylesheet" href="css/style.css">
    <script src="js/cardview/expense-functions.js"></script>
</head>

<body onload="initListeners()">
<section id="expenses">
    <!-- Modal -->
    <div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
         aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel"></h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    <form action="#" th:action="@{/expense/createExpense}" th:object="${editExpense}" method="post" id="expenseForm" enctype="multipart/form-data">
                        <div class="form-group">
                            <input type="hidden" id="modal-id" th:field="*{id}">
                            <label for="message-text" class="col-form-label">Expense Type:</label>
                            <select class="form-select form-control" aria-label="Default select example" id="modal-expenseType" th:field="*{expenseType}">
                                <option value="Entertainment" selected>Entertainment</option>
                                <option value="Official">Others</option>
                                <option value="Travel">Others</option>
                                <option value="Miscellaneous">Others</option>
                                <option value="Others">Others</option>
                            </select>
                        </div>
                        <div class="form-group">
                            <label for="message-text" class="col-form-label">Customer Type:</label>
                            <select class="form-select form-control" aria-label="Default select example" id="modal-customerType" th:field="*{customerType}">
                                <option value="Internal" selected>Internal</option>
                                <option value="External">External</option>
                                <option value="Others">Others</option>
                            </select>
                        </div>
                        <div class="form-group">
                            <label for="message-text" class="col-form-label">Purpose:</label>
                            <input type="text" class="form-control" id="modal-purpose" th:field="*{purpose}">
                        </div>
                        <div class="form-group">
                            <label for="message-text" class="col-form-label">Vendor Name:</label>
                            <input type="text" class="form-control" id="modal-vendorName" th:field="*{vendorName}">
                        </div>
                        <div class="form-group">
                            <label for="message-text" class="col-form-label">Invoice Date:</label>
                            <input type="date" class="form-control" id="modal-invoiceDate" th:field="*{invoiceDate}">
                        </div>
                        <div class="form-group">
                            <label for="message-text" class="col-form-label">Invoice No:</label>
                            <input type="text" class="form-control" id="modal-invoiceNumber" th:field="*{invoiceNumber}">
                        </div>
                        <div class="form-group">
                            <label for="message-text" class="col-form-label">Invoice Amount:</label>
                            <input type="text" class="form-control amt" id="modal-invoiceAmount" th:field="*{invoiceAmount}">
                        </div>
                        <div class="form-group">
                            <label for="message-text" class="col-form-label">Sanctioned Amount:</label>
                            <input type="text" class="form-control amt" id="modal-sanctionedAmount" th:field="*{sanctionedAmount}">
                        </div>
                        <div class="form-group">
                            <label for="message-text" class="col-form-label">Claimed Amount:</label>
                            <input type="text" class="form-control amt" id="modal-claimedAmount" th:field="*{claimedAmount}">
                        </div>
                        <div class="form-group">
                            <label for="message-text" class="col-form-label">Remarks:</label>
                            <input type="text" class="form-control" id="modal-remarks" th:field="*{remarks}">
                        </div>
                        <div class="form-group">
                            <label for="recipient-name" class="col-form-label">Attachments:</label>
                            <div class="container" id="attachmentThumbnails">
                            </div>
                            <div class="input-group mb-3">
                                <div class="custom-file">
                                    <input type="file" class="custom-file-input" id="inputGroupFile02" accept="image/*" >
                                    <label class="custom-file-label" for="inputGroupFile02" id="inputGroupFile02_val" >Choose File</label>
                                </div>
                                <div class="input-group-append">
                                    <input type="button" class="input-group-text" id="inputGroupFile03" value="Upload">
                                </div>
                            </div>
                        </div>
                        <input type="hidden" id="attachments" th:field="*{attachments}" value="">
                    </form>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancel</button>
                    <button type="button" class="btn btn-primary" id="updateButton">Update</button>
                </div>
            </div>
        </div>
    </div>

    <!-- Cards Container -->
    <div th:switch="${expenses}" class="container">
        <div class="title">
            <h1>Expenses</h1>
            <p>Card view. You can edit by clicking on a card.</p>
            <p><a href="/CardView/employee">Go to employee card view</a></p>
        </div>
        <h2 th:case="null">No record found !!</h2>
        <div th:case="*" class="row g-3">
            <div th:each="expense,pos : ${expenses}" class="col-md-3">
                <div class="card text-center">
                    <div th:unless="${expense.attachments == null}" th:id="${'cardCarousel_'+pos.index}" class="carousel slide" data-ride="carousel">
                        <ol class="carousel-indicators">
                            <li th:data-target="${'#cardCarousel_'+pos.index}" th:each="image,status : ${#strings.arraySplit(expense.attachments, '|')}"
                                th:data-slide-to="${status.index}" th:if="${status.index == 0}" class="active"></li>
                            <li th:data-target="${'#cardCarousel_'+pos.index}" th:each="image,status : ${#strings.arraySplit(expense.attachments, '|')}"
                                th:data-slide-to="${status.index}" th:unless="${status.index == 0}"></li>
                        </ol>
                        <div class="carousel-inner">
                            <div class="carousel-item active" th:each="image,status : ${#strings.arraySplit(expense.attachments, '|')}" th:if="${status.index == 0}">
                                <img th:src="'images/'+${image}" class="d-block w-100">
                            </div>
                            <div class="carousel-item" th:each="image,status : ${#strings.arraySplit(expense.attachments, '|')}" th:unless="${status.index == 0}">
                                <img th:src="'images/'+${image}" class="d-block w-100">
                            </div>
                        </div>
                        <a class="carousel-control-prev" th:href="${'#cardCarousel_'+pos.index}" data-slide="prev">
                            <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                            <span class="sr-only">Previous</span>
                        </a>
                        <a class="carousel-control-next" th:href="${'#cardCarousel_'+pos.index}" data-slide="next">
                            <span class="carousel-control-next-icon" aria-hidden="true"></span>
                            <span class="sr-only">Next</span>
                        </a>
                    </div>
                    <div class="card-body" data-toggle="modal" data-target="#exampleModal"
                         th:attr="data-expensetype=''+${expense.expenseType}+'', data-customertype=''+${expense.customerType}+''
                            , data-purpose=''+${expense.purpose}+'', data-vendorname=''+${expense.vendorName}+''
                            , data-invoicedate=''+${expense.invoiceDate}+'', data-invoicenumber=''+${expense.invoiceNumber}+''
                            , data-invoiceamount=''+${expense.invoiceAmount}+'', data-sanctionedamount=''+${expense.sanctionedAmount}+''
                            , data-claimedamount=''+${expense.claimedAmount}+'', data-remarks=''+${expense.remarks}+''
                            , data-id=''+${expense.id}+''
                            , data-attachments=''+${expense.attachments}+''">
                        <h5 class="card-title" th:text="${expense.expenseType}"></h5>
                        <p class="card-text-label"><i class="bi bi-pen"></i>Expense Type</p>
                        <p class="card-text-value" th:text="${expense.expenseType}"></p>
                        <p class="card-text-label"><i class="bi bi-pen"></i>Customer Type</p>
                        <p class="card-text-value" th:text="${expense.customerType}"></p>
                        <p class="card-text-label"><i class="bi bi-pen"></i>Purpose</p>
                        <p class="card-text-value" th:text="${expense.purpose}"></p>
                        <p class="card-text-label"><i class="bi bi-person-badge"></i>Vendor Name</p>
                        <p class="card-text-value" th:text="${expense.vendorName}"></p>
                        <p class="card-text-label"><i class="bi bi-calendar-event"></i>Invoice Date</p>
                        <p class="card-text-value" th:text="${expense.invoiceDate}"></p>
                        <p class="card-text-label"><i class="bi bi-receip"></i>Invoice No.</p>
                        <p class="card-text-value" th:text="${expense.invoiceNumber}"></p>
                        <p class="card-text-label"><i class="bi bi-currency-dollar"></i>Invoice Amount</p>
                        <p class="card-text-value amt" th:text="${expense.invoiceAmount}"></p>
                        <p class="card-text-label"><i class="bi bi-currency-dollar"></i>Sanctioned Amount</p>
                        <p class="card-text-value amt" th:text="${expense.sanctionedAmount}"></p>
                        <p class="card-text-label"><i class="bi bi-currency-dollar"></i>Claimed Amount</p>
                        <p class="card-text-value amt" th:text="${expense.claimedAmount}"></p>
                        <p class="card-text-label"><i class="bi bi-journal-code"></i>Remarks</p>
                        <p class="card-text-value" th:text="${expense.remarks}"></p>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>
</body>

</html>