CREATE DATABASE [Donation];

--USE Master
--DROP DATABASE [Donation];

USE [Donation];

CREATE TABLE [Project] (
	[Name] VARCHAR(MAX),
	[Description] VARCHAR(MAX),
	[Manager] INT,
	[Budget] INT,
	[TeamID] INT
);

CREATE TABLE [Person] (
	[ID] INT,
	[Name] VARCHAR(MAX),
	[CNIC] VARCHAR(MAX),
	[Address] VARCHAR(MAX),
	[Phone] VARCHAR(MAX),
	[DateOfBirth] DATE
);

CREATE TABLE [Donor] (
	[ID] INT,
	[DonationID] INT,
	[PledgeID] INT,
	[PersonID] INT
);

CREATE TABLE [Donation] (
	[ID] INT,
	[DonorID] VARCHAR(MAX),
	[FundID] VARCHAR(MAX),
	[Description] VARCHAR(MAX)
);

CREATE TABLE [Fund] (
	[ID] INT,
	[ProjectID] INT,
	[DonationID] INT
);

CREATE TABLE [Team] (
	[ID] INT,
	[PersonID] INT
);

CREATE TABLE [Subject] (
	[PersonID] INT,
	[Income] INT
);

--DROP TABLE [Project];
--DROP TABLE [Person];
--DROP TABLE [Donor];
--DROP TABLE [Donation];
--DROP TABLE [Fund];
--DROP TABLE [Team];
--DROP TABLE [Subject];