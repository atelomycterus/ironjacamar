/*
 * IronJacamar, a Java EE Connector Architecture implementation
 * Copyright 2014, Red Hat Inc, and individual contributors
 * as indicated by the @author tags. See the copyright.txt file in the
 * distribution for a full listing of individual contributors.
 *
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the Eclipse Public License 1.0 as
 * published by the Free Software Foundation.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the Eclipse
 * Public License for more details.
 *
 * You should have received a copy of the Eclipse Public License
 * along with this software; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
 */

package org.ironjacamar.core.workmanager.selector;

import org.ironjacamar.core.CoreBundle;
import org.ironjacamar.core.CoreLogger;
import org.ironjacamar.core.spi.workmanager.Address;

import java.util.Map;

import javax.resource.spi.work.DistributableWork;

import org.jboss.logging.Logger;
import org.jboss.logging.Messages;

/**
 * The first available selector
 *
 * @author <a href="mailto:jesper.pedersen@ironjacamar.org">Jesper Pedersen</a>
 */
public class FirstAvailable extends AbstractSelector
{
   /** The logger */
   private static CoreLogger log = Logger.getMessageLogger(CoreLogger.class, FirstAvailable.class.getName());

   /** Whether trace is enabled */
   private static boolean trace = log.isTraceEnabled();

   /** The bundle */
   private static CoreBundle bundle = Messages.getBundle(CoreBundle.class);

   /**
    * Constructor
    */
   public FirstAvailable()
   {
   }

   /**
    * {@inheritDoc}
    */
   public synchronized Address selectDistributedWorkManager(Address own, DistributableWork work)
   {
      if (trace)
         log.tracef("Own: %s, Work: %s", own, work);

      /*
        TODO

      String value = getWorkManager(work);
      if (value != null)
      {
         if (trace)
            log.tracef("WorkManager: %s", value);

         return value;
      }
      */

      Map<Address, Long> selectionMap = getSelectionMap(own.getWorkManagerId(), work);
      // No sorting needed

      if (trace)
         log.tracef("SelectionMap: %s", selectionMap);

      if (selectionMap != null)
      {
         for (Map.Entry<Address, Long> entry : selectionMap.entrySet())
         {
            Address id = entry.getKey();
            if (!own.equals(id))
            {
               Long free = entry.getValue();
               if (free != null && free.longValue() > 0)
               {
                  if (trace)
                     log.tracef("WorkManager: %s", id);
                  
                  return id;
               }
            }
         }
      }

      if (trace)
         log.tracef("WorkManager: None");

      return null;
   }
}
