# Munny

A budgetting program I'm working on for personal use. I'm hoping to use this to replace a spreadsheet I'm currently using.

This will be a command line application with the ability to store and import a 'payment schedue', and produce graphs, weekly reports and other cool stuff like that.

## The Rough Idea

Essentially, one will create a 'budget', which will be stored in a JSON file. This budget will, by default, span a year, and split this year into 52 weekly periods. The user will detail how many balances (e.g. different bank accounts) it will be tracking, and then can schedule any payments that will be made in the year. 

These payments will be sorted by period, and as each period rolls around, these payments will be added to a payment queue. The user can as review the budget, which entails updating their balances and scanning through this queue, telling the program whether these payments have been made yet. 

The overall idea is to have a quick, lightweight way to track balances through the year, and look ahead to predict how your money may rise and fall through the year. It's a nice way to avoid accidentally falling into your overdraft.

## Current State

So far, a user can initialise a new budget, add balances to track, and schedule payments (just about). Other than this the program is completely unusable - but I plan to have it stable and working before September 2019. TODOs include:

- Add the ability to add reccuring payments
- Add the ability to delete accounts and balances.
- **Store budget info in a JSON file and add the ability to load in old budgets**.
- Generate exciting graphs and stats about how your year has been. 
- Potentially work on a GUI one day.
