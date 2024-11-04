<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Book Rental</title>
<link rel="stylesheet" href="/resources/css/reset.css">
<link rel="stylesheet" href="/resources/css/admin/common.css">
<script src="/resources/js/jquery-1.12.4.min.js"></script>
<script>
	$(function(){
		$('#main-menu > li').mouseenter(function(){
			$(this).find('.sub-menu').stop().slideDown();
		});
		$('#main-menu > li').mouseleave(function(){
			$(this).find('.sub-menu').stop().slideUp();
		});
	});
</script>
</head>
<body>
	<header>
		<nav>
			<h1><a href="/admin">bookrental admin</a></h1>
			
			<ul id="main-menu">
				<li>
					<a href="#">회원관리</a>
					<ul class="sub-menu">
						<li><a href="/admin/member/register">회원등록</a></li>
						<li><a href="/admin/member/list">회원목록</a></li>
					</ul>
				</li>
			
				<li>
					<a href="#">직원관리</a>
					<ul class="sub-menu">
						<li><a href="/admin/staff/register">직원등록</a></li>
						<li><a href="/admin/staff/list">직원목록</a></li>
					</ul>
				</li>
				
				<li>
					<a href="/admin/book">도서관리</a>
					<ul class="sub-menu">
						<li><a href="/admin/book/register">도서 등록</a></li>
						<li><a href="/admin/book/list">도서  목록</a></li>
					
					</ul>
				</li>
			</ul>
			
			<c:if test="${emp == null}">
			<ul class="top-menu">
				<li><a href="/admin/staff/login">로그인</a></li>
			</ul>
			</c:if>
			
			<c:if test="${emp != null}">
			<ul class="top-menu">
				<li>${emp.staff_name} 님</li>
				<li><a href="/admin/staff/logout">로그아웃</a></li>
				<li><a href="/admin/staff/mypage?staff_id=${emp.staff_id}">마이페이지</a></li>
			</ul>
			</c:if>
		</nav>
	</header>
	
	
	
	
	
	
	
	
	
	
	
	
	
