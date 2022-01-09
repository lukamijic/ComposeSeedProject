package com.lukam.navigation.source.impl

import com.lukam.navigation.command.HostCommand
import com.lukam.navigation.source.DispatchRoutingCommand
import com.lukam.navigation.source.QueryRoutingCommands
import com.lukam.navigation.source.RoutingSource

class HostRoutingSource : RoutingSource<HostCommand>()

class HostDispatcher (routingSource: HostRoutingSource) : DispatchRoutingCommand<HostCommand> by routingSource
class HostCommands (routingSource: HostRoutingSource) : QueryRoutingCommands<HostCommand> by routingSource
